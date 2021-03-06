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
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

/**
  * Represents a server side WebSocket.
  * 
  * Instances of this class are passed into a [[io.vertx.scala.core.http.HttpServer#websocketHandler]] or provided
  * when a WebSocket handshake is manually [[io.vertx.scala.core.http.HttpServerRequest#upgrade]]ed.
  */
class ServerWebSocket(private val _asJava: io.vertx.core.http.ServerWebSocket) 
    extends io.vertx.scala.core.http.WebSocketBase {

  def asJava: java.lang.Object = _asJava

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.ServerWebSocket#setWriteQueueMaxSize]]
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

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.ServerWebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.ServerWebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.ServerWebSocket = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.ServerWebSocket = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.ServerWebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.ServerWebSocket = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.ServerWebSocket = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: => Unit): io.vertx.scala.core.http.ServerWebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def writeFrame(frame: io.vertx.scala.core.http.WebSocketFrame): io.vertx.scala.core.http.ServerWebSocket = {
    _asJava.writeFrame(frame.asJava.asInstanceOf[io.vertx.core.http.WebSocketFrame])
    this
  }

  def writeMessage(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.ServerWebSocket = {
    _asJava.writeMessage(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def closeHandler(handler: => Unit): io.vertx.scala.core.http.ServerWebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def frameHandler(handler: io.vertx.scala.core.http.WebSocketFrame => Unit): io.vertx.scala.core.http.ServerWebSocket = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.frameHandler(funcToMappedHandler(WebSocketFrame.apply)(handler))
    this
  }

  def uri(): String = {
    _asJava.uri()
  }

  /**
    * @return the WebSocket handshake path.
    */
  def path(): String = {
    _asJava.path()
  }

  /**
    * @return the WebSocket handshake query string.
    */
  def query(): String = {
    _asJava.query()
  }

  /**
    * @return the headers in the WebSocket handshake
    */
  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  /**
    * Reject the WebSocket.
    * 
    * Calling this method from the websocket handler when it is first passed to you gives you the opportunity to reject
    * the websocket, which will cause the websocket handshake to fail by returning
    * a 404 response code.
    * 
    * You might use this method, if for example you only want to accept WebSockets with a particular path.
    */
  def reject(): Unit = {
    _asJava.reject()
  }

}

object ServerWebSocket {

  def apply(_asJava: io.vertx.core.http.ServerWebSocket): io.vertx.scala.core.http.ServerWebSocket =
    new io.vertx.scala.core.http.ServerWebSocket(_asJava)
}
