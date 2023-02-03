package com.companyfinallproject_backend.companyfinallproject_backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Worker {
    private int id;
    private String name;
    private String secondname;
    private String position;
}
