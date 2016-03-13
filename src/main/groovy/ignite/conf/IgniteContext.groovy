package ignite.conf

import org.apache.ignite.configuration.IgniteConfiguration
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class IgniteContext {

    @Bean
    IgniteConfiguration igniteConfiguration() {
        new IgniteConfiguration(
                discoSpi: new TcpDiscoverySpi(
                        ipFinder: new TcpDiscoveryMulticastIpFinder(
                                addresses: [
                                        "127.0.0.1:47500",
                                        "127.0.0.1:47501",
                                        "127.0.0.1:47502",
                                        "127.0.0.1:47503",
                                ]
                        )
                ),
                peerClassLoadingEnabled: true
        )
    }
}
