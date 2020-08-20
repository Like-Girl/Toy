package cn.likegirl.java.io.mina.demo.sumup.codec;

import cn.likegirl.网络编程.mina.demo.sumup.message.AddMessage;
import cn.likegirl.网络编程.mina.demo.sumup.message.ResultMessage;
import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;


public class SumUpProtocolCodecFactory extends DemuxingProtocolCodecFactory {
	public SumUpProtocolCodecFactory(boolean server) {
		if (server) {
			super.addMessageDecoder(AddMessageDecoder.class);
			super.addMessageEncoder(ResultMessage.class,
					ResultMessageEncoder.class);
		} else // Client
		{
			super.addMessageEncoder(AddMessage.class, AddMessageEncoder.class);
			super.addMessageDecoder(ResultMessageDecoder.class);
		}
	}
}
