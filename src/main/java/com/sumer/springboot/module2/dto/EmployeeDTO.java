package com.sumer.springboot.module2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotNull(message = "Required field in Employee:name")
    @NotBlank
    @Size(min = 3,max = 10,message = "Number of chars is between 3 to 10")
    private String name;

    @Email (message = "Email should be Valid email")
    private String email;

    @Max(value = 80) //Max age should be 80
    private Integer age;

    @NotBlank
    @Pattern(regexp = "^(ADMIN|USER)$")
    private String role;//This should be either ADMIN or USER

    @PastOrPresent(message = "Date of joining should not be in future")
    private LocalDate dateOfJoining;
    @AssertTrue(message = "This has to be Active")
    @JsonProperty ("isActive")
    private Boolean isActive;


    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double Salary;
}
