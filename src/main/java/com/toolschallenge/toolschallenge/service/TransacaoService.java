package com.toolschallenge.toolschallenge.service;

import com.toolschallenge.toolschallenge.dto.DescricaoDTO;
import com.toolschallenge.toolschallenge.dto.StatusTransacaoENUM;
import com.toolschallenge.toolschallenge.dto.TransacaoDTO;
import com.toolschallenge.toolschallenge.dto.TransacaoJsonDTO;
import com.toolschallenge.toolschallenge.model.Transacao;
import com.toolschallenge.toolschallenge.repository.TransacaoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    @Autowired
    private final ModelMapper modelMapper;


    public TransacaoJsonDTO processarTransacao(TransacaoDTO transacaoDTO) {

        transacaoDTO.setDescricao(this.setDescription(transacaoDTO.getDescricao()));

        Transacao entity = modelMapper.map(transacaoDTO, Transacao.class);
        transacaoRepository.save(entity);

        return getTransacaoById(entity.getId());
    }

    private @Valid DescricaoDTO setDescription(@Valid DescricaoDTO descricao) {
        descricao.setNsu("123");
        descricao.setCodigoAutorizacao("123");
        descricao.setStatus(StatusTransacaoENUM.AUTORIZADO);
        return descricao;
    }

    public TransacaoJsonDTO processarEstorno(Long id) {
        Transacao transacao = transacaoRepository.findById(id).orElseThrow();
        transacao.getDescricao().setStatus(StatusTransacaoENUM.NEGADO.toString());
        transacaoRepository.save(transacao);
        return getTransacaoById(id);
    }

    public List<TransacaoJsonDTO> getAllTransactions() {
        return transacaoRepository.findAll().stream()
                .map(transacao -> modelMapper.map(transacao, TransacaoJsonDTO.class))
                .collect(Collectors.toList());
    }

    public TransacaoJsonDTO getTransacaoById(Long id) {
        Optional<Transacao> transacaoOptional = transacaoRepository.findById(id);
        return transacaoOptional.map(transacao -> modelMapper.map(transacao, TransacaoJsonDTO.class))
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public void deleteTransaction(Long id) {
        transacaoRepository.deleteById(id);
    }

}
