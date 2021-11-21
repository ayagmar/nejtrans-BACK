package com.teranil.nejtrans.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO implements Serializable {
    private Long id;
    private String name;
    private String Type_Document;
    @JsonIgnore
    private DossierDTO doc_dossier;
}
