package com.teranil.nejtrans.web;

import com.teranil.nejtrans.model.FormClass.FormClass;
import com.teranil.nejtrans.model.dto.DossierDTO;
import com.teranil.nejtrans.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/client")
@Api(value = "Client operations", description = "Operations pertaining to clients in Nejtrans Application")

public class ClientController {
    public final ClientService clientService;


    @ApiOperation(value = "Used by Logged in client to creater a Folder")
    @PostMapping("/createfolder")
    public ResponseEntity<String> createFolder(@RequestBody FormClass.DossierForm form) {
        return clientService.createFolder(form);
    }


    @ApiOperation(value = "Used by Logged in client to get his created Folders list")
    @GetMapping("/myfolders")
    public ResponseEntity<List<DossierDTO>> getUserFolders() {
        return clientService.getUserFolders();
    }


}