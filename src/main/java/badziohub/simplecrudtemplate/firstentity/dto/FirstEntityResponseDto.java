package badziohub.simplecrudtemplate.firstentity.dto;

import badziohub.simplecrudtemplate.firstentity.Status;

public record FirstEntityResponseDto(Long id, String content, Status status) {
}
