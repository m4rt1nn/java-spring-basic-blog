package com.pluralsight.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.blog.data.PostRepository;

@Controller
public class BlogController {
	
	private PostRepository postRepository;

	public BlogController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@RequestMapping("/")
	public String listPosts(ModelMap model) {
		model.put("posts", postRepository.getAllPosts());
		return "home";
	}
	
	@RequestMapping("/post/{id}")
	public String postDetails(@PathVariable Long id, ModelMap model) {
		model.put("post", postRepository.findById(id));
		return "post-details";
	}
}
