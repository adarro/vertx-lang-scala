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

package io.vertx.scala.core.shareddata;

import io.vertx.core.Handler

/**
  * Shared data allows you to share data safely between different parts of your application in a safe way.
  * 
  * Shared data provides:
  * <ul>
  *   <li>Cluster wide maps which can be accessed from any node of the cluster</li>
  *   <li>Cluster wide locks which can be used to give exclusive access to resources across the cluster</li>
  *   <li>Cluster wide counters used to maintain counts consistently across the cluster</li>
  *   <li>Local maps for sharing data safely in the same Vert.x instance</li>
  * </ul>
  * 
  * Please see the documentation for more information.
  */
class SharedData(private val _asJava: io.vertx.core.shareddata.SharedData) {

  def asJava: java.lang.Object = _asJava

  /**
    * Get the cluster wide map with the specified name. The map is accessible to all nodes in the cluster and data
    * put into the map from any node is visible to to any other node.
    * @param name the name of the map
    * @return the map will be returned asynchronously in this handler
    */
  def getClusterWideMap[K, V](name: String): scala.concurrent.Future[io.vertx.scala.core.shareddata.AsyncMap[K, V]] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.shareddata.AsyncMap[K, V]]()
    _asJava.getClusterWideMap(name, promiseToMappedAsyncResultHandler(AsyncMap.apply[K,V])(promise))
    promise.future
  }

  /**
    * Get a cluster wide lock with the specified name. The lock will be passed to the handler when it is available.
    * @param name the name of the lock
    * @return the handler
    */
  def getLock(name: String): scala.concurrent.Future[io.vertx.scala.core.shareddata.Lock] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.shareddata.Lock]()
    _asJava.getLock(name, promiseToMappedAsyncResultHandler(Lock.apply)(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.shareddata.SharedData#getLock]] but specifying a timeout. If the lock is not obtained within the timeout
    * a failure will be sent to the handler
    * @param name the name of the lock
    * @param timeout the timeout in ms
    * @return the handler
    */
  def getLockWithTimeout(name: String, timeout: Long): scala.concurrent.Future[io.vertx.scala.core.shareddata.Lock] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.shareddata.Lock]()
    _asJava.getLockWithTimeout(name, timeout, promiseToMappedAsyncResultHandler(Lock.apply)(promise))
    promise.future
  }

  /**
    * Get a cluster wide counter. The counter will be passed to the handler.
    * @param name the name of the counter.
    * @return the handler
    */
  def getCounter(name: String): scala.concurrent.Future[io.vertx.scala.core.shareddata.Counter] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.shareddata.Counter]()
    _asJava.getCounter(name, promiseToMappedAsyncResultHandler(Counter.apply)(promise))
    promise.future
  }

  /**
    * Return a `LocalMap` with the specific `name`.
    * @param name the name of the map
    * @return the msp
    */
  def getLocalMap[K, V](name: String): io.vertx.scala.core.shareddata.LocalMap[K, V] = {
    LocalMap.apply[K,V](_asJava.getLocalMap(name))
  }

}

object SharedData {

  def apply(_asJava: io.vertx.core.shareddata.SharedData): io.vertx.scala.core.shareddata.SharedData =
    new io.vertx.scala.core.shareddata.SharedData(_asJava)
}
