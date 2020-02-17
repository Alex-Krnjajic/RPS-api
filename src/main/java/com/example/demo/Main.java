
package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controllers  
@RestController
public class Main {

//using get method and hello-world as URI  
	@RequestMapping(method = RequestMethod.POST, path = "/playhuman", produces = MediaType.APPLICATION_JSON_VALUE)
	public String playhuman(String player1, String player2, Boolean AI) {
		RPS_Logic.RPSplay(player1, player2, AI);
		String pattern = "{'score player 1':'%s', 'score player 2':'%s', 'winner':'%s'}";
		return String.format(pattern,  RPS_Logic.scorePlayer,RPS_Logic.scoreComp,RPS_Logic.whoWon);
		
	}

	@RequestMapping(value = "/score", method = RequestMethod.GET)
	public String update(String rev) {
		StringBuilder sb = new StringBuilder(rev);

		return sb.reverse().toString();
	}

}