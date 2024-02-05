package com.p1k.p1kGram.web;

// import Security
import org.springframework.security.core.annotation.AuthenticationPrincipal;

//import web annotation
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//import another function
import com.p1k.p1kGram.config.auth.PrincipalDetails;
import com.p1k.p1kGram.service.CommentService;
import com.p1k.p1kGram.web.dto.CmRespDto;
import com.p1k.p1kGram.web.dto.comment.CommentReqDto;

//LomBok 
import lombok.RequiredArgsConstructor;

// RequiredArgsConstructor == this 생성자 주입을 자동으로 해줌
@RequiredArgsConstructor
@RestController
public class CommentController {
	
	// final 선언 = 생성자 자동 생성 this.
	private final CommentService commentService;
	
	@DeleteMapping("/comment/{id}")
	public CmRespDto<?> deleteById(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){
		
		// principal 로 다른사람들의 접근을 막음
		commentService.댓글삭제(id,principalDetails.getUser().getId());
		return new CmRespDto<>(1,null);
		
	}
}