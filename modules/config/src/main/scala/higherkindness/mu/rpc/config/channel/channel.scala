/*
 * Copyright 2017-2020 47 Degrees Open Source <https://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package higherkindness.mu.rpc
package config

import cats.Functor

package object channel {

  def ConfigForAddress[F[_]: Functor](hostPath: String, portPath: String)(
      implicit CC: ChannelConfig[F]
  ): F[ChannelForAddress] =
    CC.loadChannelAddress(hostPath, portPath)

  def ConfigForTarget[F[_]: Functor](
      target: String
  )(implicit CC: ChannelConfig[F]): F[ChannelForTarget] =
    CC.loadChannelTarget(target)

}
