package com.FullStack.BMS.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostSeatDto {

	private int id;
	private List<Integer> seats;
}
