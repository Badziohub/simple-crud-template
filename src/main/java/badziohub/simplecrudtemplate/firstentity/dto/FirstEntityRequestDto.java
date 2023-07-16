package badziohub.simplecrudtemplate.firstentity.dto;

import badziohub.simplecrudtemplate.firstentity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FirstEntityRequestDto(@NotBlank String content, @NotNull Status status) {
}
