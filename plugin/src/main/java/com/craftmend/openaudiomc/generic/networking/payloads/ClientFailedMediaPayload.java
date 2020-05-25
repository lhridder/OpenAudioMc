package com.craftmend.openaudiomc.generic.networking.payloads;

import com.craftmend.openaudiomc.generic.networking.abstracts.AbstractPacketPayload;
import com.craftmend.openaudiomc.generic.networking.enums.MediaError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFailedMediaPayload extends AbstractPacketPayload {

    private UUID client;
    private MediaError mediaError;
    private String source;

}