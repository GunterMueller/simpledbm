/***
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *    Project: www.simpledbm.org
 *    Author : Dibyendu Majumdar
 *    Email  : dibyendu@mazumdar.demon.co.uk
 */
package org.simpledbm.rss.api.st;

/**
 * Specifies the interface to a container on secondary storage. The interface
 * is small and generic to allow many different implementations. An important requirement
 * of the interface is to allow reads and writes from specified positions within
 * the container. Conceptually, the container is treated as a stream of bytes.
 *
 * @author Dibyendu Majumdar
 * @since 18-Jun-05
 */
public interface StorageContainer {

    /**
     * Returns the name of the storage container.
     */
    String getName();
    
    /**
     * Writes length number of bytes from byte array, beginning at offset,
     * to the specified position within the container. Thread safe.
     *
     * @param position The position where the write must begin, >= 0.
     * @param buffer Data to be written out.
     * @param bufferOffset The offset with data.
     * @param length The number of bytes that need to be written.
     * @throws StorageException Thrown if there was an error when writing the data.
     */
    void write(long position, byte[] buffer, int bufferOffset, int length) throws StorageException;
    
    /**
     * Reads upto length bytes from the container into the byte array beginning at offset,
     * from the specified position within the container. Thread safe.
     *
     * @param position The position where the read must begin, >= 0.
     * @param buffer Data will be read into this array.
     * @param bufferOffset The offset within the array where the read data will be placed.
     * @param length The number of bytes that is to be read.
     * @throws StorageException Thrown if there was an error when reading the data.
     * @return Number of bytes read, or <=0 if no more data available.
     */
    int  read(long position, byte[] buffer, int bufferOffset, int length) throws StorageException;
    
    /**
     * Ensures that all data written to the container is flushed to secondary
     * storage.
     * @throws StorageException Thrown if there is an error while flushing the data.
     */
    void flush() throws StorageException;
    
    /**
     * Closes the container. A container cannot be used after it has been closed.
     *
     * @throws StorageException Thrown if there is an error while closing the container.
     */
    void close() throws StorageException;
    
}
