package giovanni_565123.agrosatalert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import giovanni_565123.agrosatalert.dto.TalhaoDTO;
import giovanni_565123.agrosatalert.entity.Talhao;
import giovanni_565123.agrosatalert.exception.ResourceNotFoundException;
import giovanni_565123.agrosatalert.repository.TalhaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TalhaoService {

    @Autowired
    private TalhaoRepository repository;

    public List<TalhaoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TalhaoDTO findById(Long id) {
        Talhao talhao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + id));
        return toDTO(talhao);
    }

    public TalhaoDTO save(TalhaoDTO dto) {
        Talhao talhao = toEntity(dto);
        return toDTO(repository.save(talhao));
    }

    public TalhaoDTO update(Long id, TalhaoDTO dto) {
        Talhao talhao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + id));
        talhao.setNome(dto.getNome());
        talhao.setCultura(dto.getCultura());
        talhao.setAreaHectares(dto.getAreaHectares());
        talhao.setLocalizacao(dto.getLocalizacao());
        talhao.setDataCadastro(dto.getDataCadastro());
        return toDTO(repository.save(talhao));
    }

    public void delete(Long id) {
        Talhao talhao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + id));
        repository.delete(talhao);
    }

    private TalhaoDTO toDTO(Talhao talhao) {
        return new TalhaoDTO(
                talhao.getId(),
                talhao.getNome(),
                talhao.getCultura(),
                talhao.getAreaHectares(),
                talhao.getLocalizacao(),
                talhao.getDataCadastro());
    }

    private Talhao toEntity(TalhaoDTO dto) {
        return new Talhao(
                dto.getNome(),
                dto.getCultura(),
                dto.getAreaHectares(),
                dto.getLocalizacao(),
                dto.getDataCadastro());
    }
}