package com.example.springboot.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {
    //  These annotations are JSR-303 Validation
    @NotEmpty(message = "Email is required")
    @Length(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @NotEmpty(message = "First Name is required")
    @Length(max = 50, message = "First Name must be less than 50 characters")
    private String firstname;

    @NotEmpty(message = "Last Name is required")
    @Length(max = 50, message = "Last Name must be less than 50 characters")
    private String lastname;

    private String jobTitle;
    private String extension;
    private Integer reportsTo;
    private Integer vacationHours;
    private Integer officeId;
}
