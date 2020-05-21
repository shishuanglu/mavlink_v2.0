package com.example.myserial2.data;

public class RingBuff
{
    private byte[] ringBuff;
    private Integer nextWritePosition;
    private Integer nextReadPosition;
    private Integer buffSize;
    private Integer unusedSize;//冗余这个字段既可以提高效率，也可以区分空还是满的情况（单靠2个指针区分不了）。


    public RingBuff(int _size)
    {
        buffSize= unusedSize=_size;
        ringBuff=new byte[buffSize];
        nextReadPosition=nextWritePosition=0;
    }


    public boolean WriteBuff(byte[] _buff)
    {
        boolean ret = false;
        int bsize = _buff.length;
        if (unusedSize < bsize)
        {
            ret = false;
        }
        else
        {
            int rightLeft = buffSize - nextWritePosition;
            //need reture to head
            if (bsize > rightLeft)
            {

                System.arraycopy(_buff, 0, ringBuff, nextWritePosition, rightLeft);
                System.arraycopy(_buff, rightLeft, ringBuff, 0, bsize - rightLeft);
                nextWritePosition = bsize - rightLeft;
            }
            else if (bsize == rightLeft)
            {
                System.arraycopy(_buff, 0, ringBuff, nextWritePosition, bsize);
                nextWritePosition = 0;
            }
            else
            {
                System.arraycopy(_buff, 0, ringBuff, nextWritePosition, bsize);
                nextWritePosition += bsize;
            }
            unusedSize = unusedSize - bsize;


            ret = true;
        }

        return ret;
    }


    public boolean WriteBuff(byte[] _buff, int len)
    {
        int bsize = len;// _buff.Length;

        bsize = len > _buff.length ? _buff.length : bsize;
        if (unusedSize < bsize)
        {
            return false;
        }
        else
        {
            int rightLeft = buffSize - nextWritePosition;
            //need reture to head
            if (bsize > rightLeft)
            {
                System.arraycopy(_buff, 0, ringBuff, nextWritePosition, rightLeft);
                System.arraycopy(_buff, rightLeft, ringBuff, 0, bsize - rightLeft);
                nextWritePosition = bsize - rightLeft;
            }
            else if (bsize == rightLeft)
            {
                System.arraycopy(_buff, 0, ringBuff, nextWritePosition, bsize);
                nextWritePosition = 0;
            }
            else
            {
                System.arraycopy(_buff, 0, ringBuff, nextWritePosition, bsize);
                nextWritePosition += bsize;
            }
            unusedSize -= bsize;
            return true;
        }
    }


    /// <summary>
    /// 读缓存,是否预读，而不移动读哨兵.
    /// </summary>
    /// <param name="readbuff">读入的临时缓存</param>
    /// <returns>实际读出的数据长度</returns>
    public int ReadBuff(byte[] readbuff, int readLen, Boolean MovePosition )
    {
        if(MovePosition==null)
        {
            MovePosition=true;
        }

        int len = readLen;
        int enableread = buffSize - unusedSize;
        //Array.Clear(readbuff, 0, len);
        if (len <= 0 || enableread <= 0)
        {
            return 0;
        }
        else
        {
            int realRead = enableread >= len ? len : enableread;
            int rightLeft = buffSize - nextReadPosition;
            if (realRead > rightLeft)
            {
                System.arraycopy(ringBuff, nextReadPosition, readbuff, 0, rightLeft);
                System.arraycopy(ringBuff, 0, readbuff, rightLeft, realRead - rightLeft);
                if (MovePosition)
                {
                    nextReadPosition = realRead - rightLeft;
                }
            }
            else if (realRead == rightLeft)
            {
                System.arraycopy(ringBuff, nextReadPosition, readbuff, 0, realRead);
                if (MovePosition)
                {
                    nextReadPosition = 0;
                }
            }
            else
            {
                System.arraycopy(ringBuff, nextReadPosition, readbuff, 0, realRead);
                if (MovePosition)
                {
                    nextReadPosition += realRead;
                }
            }

            unusedSize += realRead;
            return realRead;
        }
    }

    public String GetBuffInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(":writePositon:" + nextWritePosition);
        sb.append(".  readPosition:" + nextReadPosition);
        sb.append(".  size:");
        sb.append(buffSize);
        sb.append("   .enable read:" + (buffSize-unusedSize) + ".enable write:" + unusedSize);
        sb.append("\r\n");

        sb.append("1-10 byte: ");

        for (int i = 0; i < 10; i++)
        {
            sb.append(ringBuff[i]);
        }

        return sb.toString();
    }
}