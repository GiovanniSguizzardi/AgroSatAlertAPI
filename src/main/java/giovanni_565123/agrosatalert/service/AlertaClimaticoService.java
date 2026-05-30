package giovanni_565123.agrosatalert.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import giovanni_565123.agrosatalert.dto.request.AlertaClimaticoRequest;
import giovanni_565123.agrosatalert.dto.response.AlertaClimaticoResponse;
import giovanni_565123.agrosatalert.entity.AlertaClimatico;
import giovanni_565123.agrosatalert.entity.Satelite;
import giovanni_565123.agrosatalert.entity.Talhao;
import giovanni_565123.agrosatalert.exception.ResourceNotFoundException;
import giovanni_565123.agrosatalert.repository.AlertaClimaticoRepository;
import giovanni_565123.agrosatalert.repository.SateliteRepository;
import giovanni_565123.agrosatalert.repository.TalhaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaClimaticoService {

    @Autowired
    private AlertaClimaticoRepository repository;

    @Autowired
    private TalhaoRepository talhaoRepository;

    @Autowired
    private SateliteRepository sateliteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AlertaClimaticoResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AlertaClimaticoResponse findById(Long id) {
        AlertaClimatico alerta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerta nao encontrado com id: " + id));
        return toResponse(alerta);
    }

    public List<AlertaClimaticoResponse> findByTalhaoId(Long talhaoId) {
        return repository.findByTalhaoId(talhaoId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public AlertaClimaticoResponse save(AlertaClimaticoRequest request) {
        Talhao talhao = talhaoRepository.findById(request.getTalhaoId())
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + request.getTalhaoId()));
        Satelite satelite = sateliteRepository.findById(request.getSateliteId())
                .orElseThrow(() -> new ResourceNotFoundException("Satelite nao encontrado com id: " + request.getSateliteId()));
        AlertaClimatico alerta = modelMapper.map(request, AlertaClimatico.class);
        alerta.setTalhao(talhao);
        alerta.setSatelite(satelite);
        return toResponse(repository.save(alerta));
    }

    public AlertaClimaticoResponse update(Long id, AlertaClimaticoRequest request) {
        AlertaClimatico alerta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerta nao encontrado com id: " + id));
        Talhao talhao = talhaoRepository.findById(request.getTalhaoId())
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + request.getTalhaoId()));
        Satelite satelite = sateliteRepository.findById(request.getSateliteId())
                .orElseThrow(() -> new ResourceNotFoundException("Satelite nao encontrado com id: " + request.getSateliteId()));
        modelMapper.map(request, alerta);
        alerta.setTalhao(talhao);
        alerta.setSatelite(satelite);
        return toResponse(repository.save(alerta));
    }

    public void delete(Long id) {
        AlertaClimatico alerta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerta nao encontrado com id: " + id));
        repository.delete(alerta);
    }

    private AlertaClimaticoResponse toResponse(AlertaClimatico alerta) {
        AlertaClimaticoResponse response = modelMapper.map(alerta, AlertaClimaticoResponse.class);
        response.setTalhaoId(alerta.getTalhao().getId());
        response.setTalhaoNome(alerta.getTalhao().getNome());
        response.setSateliteId(alerta.getSatelite().getId());
        response.setSateliteNome(alerta.getSatelite().getNome());
        return response;
    }
}