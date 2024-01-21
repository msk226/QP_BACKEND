package qp.official.qp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import qp.official.qp.apiPayload.ApiResponse;
import qp.official.qp.apiPayload.code.status.SuccessStatus;
import qp.official.qp.converter.QuestionConverter;
import qp.official.qp.domain.Question;
import qp.official.qp.service.QuestionService.QuestionCommandService;
import qp.official.qp.service.QuestionService.QuestionQueryService;
import qp.official.qp.validation.annotation.ExistQuestion;
import qp.official.qp.web.dto.QuestionRequestDTO;
import qp.official.qp.web.dto.QuestionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionCommandService questionCommandService;

    // 질문 작성
    @PostMapping("/")
    public ApiResponse<QuestionResponseDTO.CreateResultDTO> createQuestion(
            @RequestBody @Valid QuestionRequestDTO.CreateDTO request
    ) {
        return ApiResponse.onSuccess(
                SuccessStatus.Question_OK.getCode(),
                SuccessStatus.Question_OK.getMessage(),
                QuestionConverter.toCreateResultDTO(
                        questionCommandService.createQuestion(request)
                )
        );
    }

    // 특정 질문 조회
    @GetMapping("/{questionId}")
    public ApiResponse<QuestionResponseDTO.QuestionPreviewDTO> findQuestion(
            @PathVariable Long questionId
    ) {
        return null;
    }

    // 질문 페이징 조회
    @GetMapping(path = "/", params = {"page, size"})
    public ApiResponse<QuestionResponseDTO.QuestionPreviewListDTO> findQuestionByPaging(@RequestParam Integer page, @RequestParam Integer size) {
        return null;
    }

    // 질문 검색 조회
    @GetMapping(path = "/", params = {"title", "page", "size"})
    public ApiResponse<QuestionResponseDTO.QuestionPreviewListDTO> findQuestionByTitle(
            @RequestParam String title,
            @RequestParam Integer page,
            @RequestParam Integer size) {
        return null;
    }

    // 질문 삭제
    @DeleteMapping("/{questionId}")
    public ApiResponse<QuestionResponseDTO.CreateResultDTO> deleteQuestion(@PathVariable Long questionId) {
        return null;
    }


    // 질문 수정
    @PatchMapping("/{questionId}")
    public ApiResponse<QuestionResponseDTO.QuestionUpdateResultDTO> updateQuestion(
            @RequestBody QuestionRequestDTO.UpdateDTO request,
            @PathVariable Long questionId) {
        return null;
    }

}
