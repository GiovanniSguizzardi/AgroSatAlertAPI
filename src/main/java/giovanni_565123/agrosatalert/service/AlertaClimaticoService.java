package giovanni_565123.agrosatalert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import giovanni_565123.agrosatalert.dto.AlertaClimaticoDTO;
import giovanni_565123.agrosatalert.entity.AlertaClimatico;
import giovanni_565123.agrosatalert.entity.Talhao;
import giovanni_565123.agrosatalert.exception.ResourceNotFoundException;
import giovanni_565123.agrosatalert.repository.AlertaClimaticoRepository;
import giovanni_565123.agrosatalert.repository.TalhaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaClimaticoService {

    @Autowired
    private AlertaClimaticoRepository repository;

    @Autowired
    private TalhaoRepository talhaoRepository;

    public List<AlertaClimaticoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AlertaClimaticoDTO findById(Long id) {
        AlertaClimatico alerta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerta nao encontrado com id: " + id));
        return toDTO(alerta);
    }

    public List<AlertaClimaticoDTO> findByTalhaoId(Long talhaoId) {
        return repository.findByTalhaoId(talhaoId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AlertaClimaticoDTO save(AlertaClimaticoDTO dto) {
        Talhao talhao = talhaoRepository.findById(dto.getTalhaoId())
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + dto.getTalhaoId()));
        AlertaClimatico alerta = toEntity(dto, talhao);
        return toDTO(repository.save(alerta));
    }

    public AlertaClimaticoDTO update(Long id, AlertaClimaticoDTO dto) {
        AlertaClimatico alerta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerta nao encontrado com id: " + id));
        Talhao talhao = talhaoRepository.findById(dto.getTalhaoId())
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + dto.getTalhaoId()));
        alerta.setTipoAlerta(dto.getTipoAlerta());
        alerta.setSeveridade(dto.getSeveridade());
        alerta.setImpactoEstimado(dto.getImpactoEstimado());
        alerta.setDataEvento(dto.getDataEvento());
        alerta.setStatus(dto.getStatus());
        alerta.setTalhao(talhao);
        return toDTO(repository.save(alerta));
    }

    public void delete(Long id) {
        AlertaClimatico alerta = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerta nao encontrado com id: " + id));
        repository.delete(alerta);
    }

    private AlertaClimaticoDTO toDTO(AlertaClimatico alerta) {
        return new AlertaClimaticoDTO(
                alerta.getId(),
                alerta.getTipoAlerta(),
                alerta.getSeveridade(),
                alerta.getImpactoEstimado(),
                alerta.getDataEvento(),
                alerta.getStatus(),
                alerta.getTalhao().getId());
    }

    private AlertaClimatico toEntity(AlertaClimaticoDTO dto, Talhao talhao) {
        return new AlertaClimatico(
                dto.getTipoAlerta(),
                dto.getSeveridade(),
                dto.getImpactoEstimado(),
                dto.getDataEvento(),
                dto.getStatus(),
                talhao);
    }
}