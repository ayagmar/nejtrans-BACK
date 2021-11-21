package com.teranil.nejtrans.web;

import com.teranil.nejtrans.model.dto.DossierDTO;
import com.teranil.nejtrans.service.DossierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DossierController {

    private final DossierService dossierService;

    @GetMapping("/api/dossiers")
    public List<DossierDTO> getAll(){
        return dossierService.getAll();
    }

}
