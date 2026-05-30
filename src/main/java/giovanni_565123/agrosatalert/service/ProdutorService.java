package giovanni_565123.agrosatalert.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import giovanni_565123.agrosatalert.dto.request.ProdutorRequest;
import giovanni_565123.agrosatalert.dto.response.ProdutorResponse;
import giovanni_565123.agrosatalert.entity.Produtor;
import giovanni_565123.agrosatalert.exception.ResourceNotFoundException;
import giovanni_565123.agrosatalert.repository.ProdutorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutorService {

    @Autowired
    private ProdutorRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutorResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProdutorResponse.class))
                .collect(Collectors.toList());
    }

    public ProdutorResponse findById(Long id) {
        Produtor produtor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produtor nao encontrado com id: " + id));
        return modelMapper.map(produtor, ProdutorResponse.class);
    }

    public ProdutorResponse save(ProdutorRequest request) {
        Produtor produtor = modelMapper.map(request, Produtor.class);
        return modelMapper.map(repository.save(produtor), ProdutorResponse.class);
    }

    public ProdutorResponse update(Long id, ProdutorRequest request) {
        Produtor produtor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produtor nao encontrado com id: " + id));
        modelMapper.map(request, produtor);
        return modelMapper.map(repository.save(produtor), ProdutorResponse.class);
    }

    public void delete(Long id) {
        Produtor produtor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produtor nao encontrado com id: " + id));
        repository.delete(produtor);
    }
}