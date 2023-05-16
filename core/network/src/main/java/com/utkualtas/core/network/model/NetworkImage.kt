package com.utkualtas.core.network.model

import com.utkualtas.core.model.Image
import kotlinx.serialization.Serializable

@Serializable
data class NetworkImage(
    val thumb: String? = null,
    val small: String? = null,
    val large: String? = null,
)

internal fun NetworkImage.asExternal(): Image = Image(
    thumb = thumb.orEmpty(),
    small = small.orEmpty(),
    large = large.orEmpty(),
)