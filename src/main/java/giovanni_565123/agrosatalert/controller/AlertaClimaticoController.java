package giovanni_565123.agrosatalert.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import giovanni_565123.agrosatalert.dto.request.AlertaClimaticoRequest;
import giovanni_565123.agrosatalert.dto.response.AlertaClimaticoResponse;
import giovanni_565123.agrosatalert.service.AlertaClimaticoService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/alertas")
public class AlertaClimaticoController {

    @Autowired
    private AlertaClimaticoService service;

    @GetMapping
    public ResponseEntity<List<AlertaClimaticoResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaClimaticoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/talhao/{talhaoId}")
    public ResponseEntity<List<AlertaClimaticoResponse>> findByTalhaoId(@PathVariable Long talhaoId) {
        return ResponseEntity.ok(service.findByTalhaoId(talhaoId));
    }

    @PostMapping
    public ResponseEntity<AlertaClimaticoResponse> save(@RequestBody @Valid AlertaClimaticoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertaClimaticoResponse> update(@PathVariable Long id, @RequestBody @Valid AlertaClimaticoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}