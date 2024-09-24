package com.uga.bookStore.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uga.bookStore.model.Books;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data

public class Filter_Response {
	@Id
	private String status ;
	private String ResponseCode;
	private String description;
	private List<Books> details;
}
