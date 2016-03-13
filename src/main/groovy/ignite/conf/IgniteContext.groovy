package ignite.conf

import ignite.service.CacheLoader
import org.apache.ignite.Ignite
import org.apache.ignite.Ignition
import org.apache.ignite.cache.CacheAtomicityMode
import org.apache.ignite.cache.CacheMode
import org.apache.ignite.configuration.CacheConfiguration
import org.apache.ignite.configuration.IgniteConfiguration
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class IgniteContext {

    @Bean
    IgniteConfiguration igniteConfiguration(CacheLoader cacheLoader) {
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
                lifecycleBeans: cacheLoader,
                peerClassLoadingEnabled: true,
                cacheCfg: [
                        new CacheConfiguration(
                                name: "person",
                                cacheMode: CacheMode.REPLICATED,
                                atomicityMode: CacheAtomicityMode.TRANSACTIONAL
//                                cacheStoreFactory: FactoryBuilder.factoryOf(PersonCacheAdapter),
//                                writeThrough: true,
//                                readThrough: true
                        )
                ]
        )
    }

    @Bean
    Ignite ignite(IgniteConfiguration igniteConfiguration) {
        Ignition.start(igniteConfiguration)
    }
}
