/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.core.streams;


/**
  * Pumps data from a [[io.vertx.scala.core.streams.ReadStream]] to a [[io.vertx.scala.core.streams.WriteStream]] and performs flow control where necessary to
  * prevent the write stream buffer from getting overfull.
  * 
  * Instances of this class read items from a [[io.vertx.scala.core.streams.ReadStream]] and write them to a [[io.vertx.scala.core.streams.WriteStream]]. If data
  * can be read faster than it can be written this could result in the write queue of the [[io.vertx.scala.core.streams.WriteStream]] growing
  * without bound, eventually causing it to exhaust all available RAM.
  * 
  * To prevent this, after each write, instances of this class check whether the write queue of the [[io.vertx.scala.core.streams.WriteStream]] is full, and if so, the [[io.vertx.scala.core.streams.ReadStream]] is paused, and a `drainHandler` is set on the
  * [[io.vertx.scala.core.streams.WriteStream]].
  * 
  * When the [[io.vertx.scala.core.streams.WriteStream]] has processed half of its backlog, the `drainHandler` will be
  * called, which results in the pump resuming the [[io.vertx.scala.core.streams.ReadStream]].
  * 
  * This class can be used to pump from any [[io.vertx.scala.core.streams.ReadStream]] to any [[io.vertx.scala.core.streams.WriteStream]],
  * e.g. from an [[io.vertx.scala.core.http.HttpServerRequest]] to an [[io.vertx.scala.core.file.AsyncFile]],
  * or from [[io.vertx.scala.core.net.NetSocket]] to a [[io.vertx.scala.core.http.WebSocket]].
  * 
  * Please see the documentation for more information.
  */
class Pump(private val _asJava: io.vertx.core.streams.Pump) {

  def asJava: java.lang.Object = _asJava

  /**
    * Set the write queue max size to `maxSize`
    * @param maxSize the max size
    * @return a reference to this, so the API can be used fluently
    */
  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.streams.Pump = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  /**
    * Start the Pump. The Pump can be started and stopped multiple times.
    * @return a reference to this, so the API can be used fluently
    */
  def start(): io.vertx.scala.core.streams.Pump = {
    _asJava.start()
    this
  }

  /**
    * Stop the Pump. The Pump can be started and stopped multiple times.
    * @return a reference to this, so the API can be used fluently
    */
  def stop(): io.vertx.scala.core.streams.Pump = {
    _asJava.stop()
    this
  }

  /**
    * Return the total number of items pumped by this pump.
    */
  def numberPumped(): Int = {
    _asJava.numberPumped()
  }

}

object Pump {

  def apply(_asJava: io.vertx.core.streams.Pump): io.vertx.scala.core.streams.Pump =
    new io.vertx.scala.core.streams.Pump(_asJava)

  def pump[T](rs: io.vertx.scala.core.streams.ReadStream[T], ws: io.vertx.scala.core.streams.WriteStream[T]): io.vertx.scala.core.streams.Pump = {
    Pump.apply(io.vertx.core.streams.Pump.pump(rs.asJava.asInstanceOf[io.vertx.core.streams.ReadStream[T]], ws.asJava.asInstanceOf[io.vertx.core.streams.WriteStream[T]]))
  }

  def pump[T](rs: io.vertx.scala.core.streams.ReadStream[T], ws: io.vertx.scala.core.streams.WriteStream[T], writeQueueMaxSize: Int): io.vertx.scala.core.streams.Pump = {
    Pump.apply(io.vertx.core.streams.Pump.pump(rs.asJava.asInstanceOf[io.vertx.core.streams.ReadStream[T]], ws.asJava.asInstanceOf[io.vertx.core.streams.WriteStream[T]], writeQueueMaxSize))
  }
}
