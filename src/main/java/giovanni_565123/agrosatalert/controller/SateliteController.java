package giovanni_565123.agrosatalert.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import giovanni_565123.agrosatalert.dto.request.SateliteRequest;
import giovanni_565123.agrosatalert.dto.response.SateliteResponse;
import giovanni_565123.agrosatalert.service.SateliteService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/satelites")
public class SateliteController {

    @Autowired
    private SateliteService service;

    @GetMapping
    public ResponseEntity<List<SateliteResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SateliteResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SateliteResponse> save(@RequestBody @Valid SateliteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SateliteResponse> update(@PathVariable Long id, @RequestBody @Valid SateliteRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

