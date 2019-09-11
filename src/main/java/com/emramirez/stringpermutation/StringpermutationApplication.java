package com.emramirez.stringpermutation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * O(n)
 */
@SpringBootApplication
public class StringpermutationApplication {

    private static List<String> permutations = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(StringpermutationApplication.class, args);

		permutate("hola");
	}

	public static void permutate(String s) {
		List<Character> characters = new ArrayList<>();
		for (Character character: s.toCharArray()) {
			characters.add(character);
		}

		Character character = s.charAt(0);
		if (permutations.isEmpty()) {
		    permutations.add(String.valueOf(character));
        } else {
            List<String> temp = new ArrayList<>();
            for (String eachWord: permutations) {
                for(int i = 0; i <= eachWord.length(); i++) {
                    String newWord = eachWord.substring(0, i).concat(String.valueOf(character)).concat(eachWord.substring(i));
                    temp.add(newWord);
                }
            }
            permutations = temp;
        }

        System.out.println(permutations);
        if (s.length() > 1) {
            permutate(s.substring(1));
        }
	}
}
