package giovanni_565123.agrosatalert.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import giovanni_565123.agrosatalert.dto.request.TalhaoRequest;
import giovanni_565123.agrosatalert.dto.response.TalhaoResponse;
import giovanni_565123.agrosatalert.entity.Produtor;
import giovanni_565123.agrosatalert.entity.Talhao;
import giovanni_565123.agrosatalert.exception.ResourceNotFoundException;
import giovanni_565123.agrosatalert.repository.ProdutorRepository;
import giovanni_565123.agrosatalert.repository.TalhaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TalhaoService {

    @Autowired
    private TalhaoRepository repository;

    @Autowired
    private ProdutorRepository produtorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TalhaoResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TalhaoResponse findById(Long id) {
        Talhao talhao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + id));
        return toResponse(talhao);
    }

    public List<TalhaoResponse> findByProdutorId(Long produtorId) {
        return repository.findByProdutorId(produtorId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TalhaoResponse save(TalhaoRequest request) {
        Produtor produtor = produtorRepository.findById(request.getProdutorId())
                .orElseThrow(() -> new ResourceNotFoundException("Produtor nao encontrado com id: " + request.getProdutorId()));
        Talhao talhao = modelMapper.map(request, Talhao.class);
        talhao.setProdutor(produtor);
        return toResponse(repository.save(talhao));
    }

    public TalhaoResponse update(Long id, TalhaoRequest request) {
        Talhao talhao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + id));
        Produtor produtor = produtorRepository.findById(request.getProdutorId())
                .orElseThrow(() -> new ResourceNotFoundException("Produtor nao encontrado com id: " + request.getProdutorId()));
        modelMapper.map(request, talhao);
        talhao.setProdutor(produtor);
        return toResponse(repository.save(talhao));
    }

    public void delete(Long id) {
        Talhao talhao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Talhao nao encontrado com id: " + id));
        repository.delete(talhao);
    }

    private TalhaoResponse toResponse(Talhao talhao) {
        TalhaoResponse response = modelMapper.map(talhao, TalhaoResponse.class);
        response.setProdutorId(talhao.getProdutor().getId());
        response.setProdutorNome(talhao.getProdutor().getNome());
        return response;
    }
}