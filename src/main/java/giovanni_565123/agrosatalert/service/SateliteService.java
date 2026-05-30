package giovanni_565123.agrosatalert.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import giovanni_565123.agrosatalert.dto.request.SateliteRequest;
import giovanni_565123.agrosatalert.dto.response.SateliteResponse;
import giovanni_565123.agrosatalert.entity.Satelite;
import giovanni_565123.agrosatalert.exception.ResourceNotFoundException;
import giovanni_565123.agrosatalert.repository.SateliteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SateliteService {

    @Autowired
    private SateliteRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SateliteResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, SateliteResponse.class))
                .collect(Collectors.toList());
    }

    public SateliteResponse findById(Long id) {
        Satelite satelite = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Satelite nao encontrado com id: " + id));
        return modelMapper.map(satelite, SateliteResponse.class);
    }

    public SateliteResponse save(SateliteRequest request) {
        Satelite satelite = modelMapper.map(request, Satelite.class);
        return modelMapper.map(repository.save(satelite), SateliteResponse.class);
    }

    public SateliteResponse update(Long id, SateliteRequest request) {
        Satelite satelite = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Satelite nao encontrado com id: " + id));
        modelMapper.map(request, satelite);
        return modelMapper.map(repository.save(satelite), SateliteResponse.class);
    }

    public void delete(Long id) {
        Satelite satelite = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Satelite nao encontrado com id: " + id));
        repository.delete(satelite);
    }
}
