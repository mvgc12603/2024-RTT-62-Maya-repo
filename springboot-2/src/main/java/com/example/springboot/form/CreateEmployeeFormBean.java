package com.example.springboot.form;

import com.example.springboot.validation.EmployeeEmailUnique;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {
    // when the user exists in the database this value will be populated with the id of the database field
    // this field is only set when the user called the /employee/edit URL and gives a valid employee id
    // if this field is null, then it is a create
    private Integer employeeId;


    //  These annotations are JSR-303 Validation
    @NotEmpty(message = "Email is required")
    @Length(max = 100, message = "Email must not be over 100 characters")
    @Email(message = "This must be a valid email")
//    @EmployeeEmailUnique(message = "This email is already in use")
    private String email;

    @NotEmpty(message = "First Name is required")
    @Pattern(regexp = "[a-zA-Z]+", message = "Firstname must have characters only.")
    @Length(max = 50, message = "First Name must not be over 50 characters")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @Pattern(regexp = "[a-zA-Z]+", message = "Lastname must have characters only.")
    @Length(max = 50, message = "Last Name must not be over 50 characters")
    private String lastName;

    @NotEmpty(message = "Job Title is required")
    @Length(max = 50, message = "Job Title must not be over 50 characters")
    private String jobTitle;

    @NotEmpty(message = "Extension is required")
    @Length(max = 10, message = "Extension must not be over 10 characters")
    private String extension;

    @Positive(message = "Reports To is required")
    private Integer reportsTo;

    @NotNull(message = "Vacation Hours is required")
    @Min(value = 1, message = "Invalid Vacation Hours")
    private Integer vacationHours;

    @Positive(message = "Office is required")
    private Integer officeId;
    }