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

package io.vertx.scala.core.http;

import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

/**
  * Represents a client-side WebSocket.
  */
class WebSocket(private val _asJava: io.vertx.core.http.WebSocket) 
    extends io.vertx.scala.core.http.WebSocketBase {

  def asJava: java.lang.Object = _asJava

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the event bus - the ID of that
    * handler is given by this method.
    * 
    * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    * @return the binary handler id
    */
  def binaryHandlerID(): String = {
    _asJava.binaryHandlerID()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  def textHandlerID(): String = {
    _asJava.textHandlerID()
  }

  /**
    * Close the WebSocket.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.remoteAddress())
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.localAddress())
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.WebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.WebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.WebSocket = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.WebSocket = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.WebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocket = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.WebSocket = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: => Unit): io.vertx.scala.core.http.WebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def writeFrame(frame: io.vertx.scala.core.http.WebSocketFrame): io.vertx.scala.core.http.WebSocket = {
    _asJava.writeFrame(frame.asJava.asInstanceOf[io.vertx.core.http.WebSocketFrame])
    this
  }

  def writeMessage(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocket = {
    _asJava.writeMessage(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def closeHandler(handler: => Unit): io.vertx.scala.core.http.WebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def frameHandler(handler: io.vertx.scala.core.http.WebSocketFrame => Unit): io.vertx.scala.core.http.WebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.frameHandler(funcToMappedHandler(WebSocketFrame.apply)(handler))
    this
  }

}

object WebSocket {

  def apply(_asJava: io.vertx.core.http.WebSocket): io.vertx.scala.core.http.WebSocket =
    new io.vertx.scala.core.http.WebSocket(_asJava)
}
