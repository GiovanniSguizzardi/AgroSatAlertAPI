package giovanni_565123.agrosatalert.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import giovanni_565123.agrosatalert.dto.request.ProdutorRequest;
import giovanni_565123.agrosatalert.dto.response.ProdutorResponse;
import giovanni_565123.agrosatalert.service.ProdutorService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/produtores")
public class ProdutorController {

    @Autowired
    private ProdutorService service;

    @GetMapping
    public ResponseEntity<List<ProdutorResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutorResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProdutorResponse> save(@RequestBody @Valid ProdutorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutorResponse> update(@PathVariable Long id, @RequestBody @Valid ProdutorRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
