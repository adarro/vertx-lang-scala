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

package io.vertx.scala.core;

import java.util.Map.Entry

/**
  * This class represents a MultiMap of String keys to a List of String values.
  * 
  * It's useful in Vert.x to represent things in Vert.x like HTTP headers and HTTP parameters which allow
  * multiple values for keys.
  */
class MultiMap(private val _asJava: io.vertx.core.MultiMap) {

  def asJava: java.lang.Object = _asJava

  /**
    * Returns the value of with the specified name.  If there are
    * more than one values for the specified name, the first value is returned.
    * @param name The name of the header to search
    * @return The first header value or {@code null} if there is no such entry
    */
  def get(name: String): String = {
    _asJava.get(name)
  }

  /**
    * Returns the values with the specified name
    * @param name The name to search
    * @return A immutable [[scala.collection.immutable.List]] of values which will be empty if no values are found
    */
  def getAll(name: String): List[String] = {
    import scala.collection.JavaConverters._
    _asJava.getAll(name).asScala.map(x => x:String).toList
  }

  /**
    * Checks to see if there is a value with the specified name
    * @param name The name to search for
    * @return true if at least one entry is found
    */
  def contains(name: String): Boolean = {
    _asJava.contains(name)
  }

  /**
    * Return true if empty
    */
  def isEmpty(): Boolean = {
    _asJava.isEmpty()
  }

  /**
    * Gets a immutable Set of all names
    * @return A [[scala.collection.immutable.Set]] of all names
    */
  def names(): Set[String] = {
    import scala.collection.JavaConverters._
    _asJava.names().asScala.map(x => x:String).toSet
  }

  /**
    * Adds a new value with the specified name and value.
    * @param name The name
    * @param value The value being added
    * @return a reference to this, so the API can be used fluently
    */
  def add(name: String, value: String): io.vertx.scala.core.MultiMap = {
    _asJava.add(name, value)
    this
  }

  /**
    * Adds all the entries from another MultiMap to this one
    * @return a reference to this, so the API can be used fluently
    */
  def addAll(map: io.vertx.scala.core.MultiMap): io.vertx.scala.core.MultiMap = {
    _asJava.addAll(map.asJava.asInstanceOf[io.vertx.core.MultiMap])
    this
  }

  /**
    * Sets a value under the specified name.
    * 
    * If there is an existing header with the same name, it is removed.
    * @param name The name
    * @param value The value
    * @return a reference to this, so the API can be used fluently
    */
  def set(name: String, value: String): io.vertx.scala.core.MultiMap = {
    _asJava.set(name, value)
    this
  }

  /**
    * Cleans this instance.
    * @return a reference to this, so the API can be used fluently
    */
  def setAll(map: io.vertx.scala.core.MultiMap): io.vertx.scala.core.MultiMap = {
    _asJava.setAll(map.asJava.asInstanceOf[io.vertx.core.MultiMap])
    this
  }

  /**
    * Removes the value with the given name
    * @param name The name of the value to remove
    * @return a reference to this, so the API can be used fluently
    */
  def remove(name: String): io.vertx.scala.core.MultiMap = {
    _asJava.remove(name)
    this
  }

  /**
    * Removes all
    * @return a reference to this, so the API can be used fluently
    */
  def clear(): io.vertx.scala.core.MultiMap = {
    _asJava.clear()
    this
  }

  /**
    * Return the number of keys.
    */
  def size(): Int = {
    _asJava.size()
  }

}

object MultiMap {

  def apply(_asJava: io.vertx.core.MultiMap): io.vertx.scala.core.MultiMap =
    new io.vertx.scala.core.MultiMap(_asJava)
}
