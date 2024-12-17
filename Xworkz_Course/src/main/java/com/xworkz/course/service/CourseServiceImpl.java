package com.xworkz.course.service;

import com.xworkz.course.dto.SignupDTO;
import com.xworkz.course.entity.CourseEntity;
import com.xworkz.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl() {
        System.out.println("No-arg const in CourseServiceImpl");
    }

    @Override
    public boolean validate(SignupDTO signupDTO) {
        System.out.println("validate in courseServiceImpl");

        boolean isValid = true;
        String name = signupDTO.getName();
        if (name.length() > 5 && name.matches("^[a-zA-Z0-9]+$")) {
            System.out.println("name valid");
        } else {
            isValid = false;
            System.out.println("name is invalid");
        }

        int age = signupDTO.getAge();
        if (age > 18) {
            System.out.println("age is valid");
        } else {
            isValid = false;
            System.out.println("age is invalid");
        }

        String email = signupDTO.getEmail();
        if (email.contains("@")) {
            System.out.println("email is valid");
        } else {
            isValid = false;
            System.out.println("email is invalid");
        }

        String password = signupDTO.getPassword();
        if (password != null) {
            password = passwordEncoder.encode(signupDTO.getPassword());
        }

        String confirmPassword = signupDTO.getConfirmPassword();
        if (confirmPassword.equals(signupDTO.getPassword())) {
            System.out.println("confirm password is valid");
        } else {
            isValid = false;
            System.out.println("confirm password is invalid");
        }

        String phone = signupDTO.getPhone();
        if (phone.length() == 10 && phone.startsWith("9")) {
            System.out.println("phone is valid");
        } else {
            isValid = false;
            System.out.println("phone is invalid");
        }

        if (isValid) {
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName(signupDTO.getName());
            courseEntity.setAge(signupDTO.getAge());
            courseEntity.setEmail(signupDTO.getEmail());
            courseEntity.setPhone(signupDTO.getPhone());
            courseEntity.setPassword(password);

            boolean saved = courseRepository.valid(courseEntity);
        }
        System.out.println(isValid);
        return isValid;
    }

    @Override
    public String getName(String name, String password) {
        System.out.println("This is service get name method");

        CourseEntity entity = courseRepository.getNAme(name);
        if (entity != null) {
            if (passwordEncoder.matches(password, entity.getPassword())) {
                System.out.println(entity.getName());
                return entity.getName();
            }
        }
        return "Data did not get";
    }
}
