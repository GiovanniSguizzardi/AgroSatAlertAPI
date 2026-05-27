package giovanni_565123.agrosatalert.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import giovanni_565123.agrosatalert.dto.TalhaoDTO;
import giovanni_565123.agrosatalert.service.TalhaoService;

import java.util.List;

@RestController
@RequestMapping("/talhoes")
public class TalhaoController {

    @Autowired
    private TalhaoService service;

    @GetMapping
    public ResponseEntity<List<TalhaoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TalhaoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TalhaoDTO> save(@RequestBody @Valid TalhaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TalhaoDTO> update(@PathVariable Long id, @RequestBody @Valid TalhaoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}