package com.example.springboot.form;

import com.example.springboot.validation.EmployeeEmailUnique;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

    @Getter
    @Setter
    @ToString
    public class CreateEmployeeFormBean {

        // when the user exists in the database this value will be populated with the id of the database field
        // this field is only set when the user called the /employee/edit URL and gives a valid employee id
        // if this field is null, then it is a create
        private Integer employeeId;


        // these annotations are called JSR-303 validation
        @Length(max = 100, message = "Email must be less than 100 characters")
        @NotEmpty(message="Email is required.")
        @Email(message = "This must be a valid email")
        @EmployeeEmailUnique(message = "This email is already in use.")
        private String email;

        @Pattern(regexp="[a-zA-Z]+", message = "Firstname must have characters only.")
        @Length(max = 50, message = "Firstname must be less than 50 characters")
        @NotEmpty(message = "Firstname is required.")
        private String firstName;

        @Length(max = 50, message = "Lastname must be less than 50 characters")
        @NotEmpty(message = "Lastname is required.")
        private String lastName;

        private Integer officeId;

        // we are going to make this data type an integer because we know we want to write to the database as an integer
        private Integer reportsTo;

    }