/**
 * diffr - just another diff tool.
 * Copyright (C) 2020 Anthony Li
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.anthli.diffr.serializer

import com.anthli.diffr.Diff
import com.anthli.diffr.Operation
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.StringDescriptor

/**
 * External serializer for the [Diff] class.
 */
@Serializer(forClass = Operation::class)
object OperationSerializer: KSerializer<Operation> {
  override val descriptor: SerialDescriptor = StringDescriptor

  override fun deserialize(decoder: Decoder): Operation {
    return Operation.valueOf(decoder.decodeString().toUpperCase())
  }

  override fun serialize(encoder: Encoder, obj: Operation) {
    encoder.encodeString(obj.toString())
  }
}

@Serializer(forClass = Diff::class)
@Serializable(with = OperationSerializer::class)
object DiffSerializer {
  override fun deserialize(decoder: Decoder): Diff {
    return Diff(Operation.values()[decoder.decodeEnum(StringDescriptor)], decoder.decodeString())
  }

  override fun serialize(encoder: Encoder, obj: Diff) {
    encoder.encodeString("${obj.op}${obj.text}")
  }
}