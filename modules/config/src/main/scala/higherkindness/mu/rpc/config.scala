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

import cats.effect.Sync
import pureconfig._
import com.typesafe.config.{Config, ConfigFactory}

package object config {

  implicit def syncConfigM[F[_]](implicit F: Sync[F]): ConfigM[F] = new ConfigM[F] {
    def load: F[Config] = F.delay(ConfigSource.fromConfig(ConfigFactory.load()).loadOrThrow[Config])
  }

}
