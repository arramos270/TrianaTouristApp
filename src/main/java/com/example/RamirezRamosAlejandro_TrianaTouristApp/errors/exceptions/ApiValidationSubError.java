package com.example.RamirezRamosAlejandro_TrianaTouristApp.errors.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiValidationSubError {

    private String objeto;
    private String campo;
    private Object valorRechazado;
    private String mensaje;
}
