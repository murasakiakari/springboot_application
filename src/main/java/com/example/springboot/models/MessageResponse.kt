package com.example.springboot.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MessageResponse(
        val message: String
) {}
