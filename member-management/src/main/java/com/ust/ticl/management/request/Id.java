package com.ust.ticl.management.request;

import java.util.List;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Id extends BaseRequest{
	private List<Integer> idList;

}
