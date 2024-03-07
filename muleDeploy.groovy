muleDeploy {
    // version of the tool
    version '1.0'

    apiSpecification {
        name 'Mule Sample Project TSS'
        exchangeAssetId 'mule-sample-project-tss-spec'
    }

    policies {
        clientEnforcementPolicyBasic {
            // version is optional (will use version in this library by default)
            version '1.2.1'
        }
    }

    
    cloudHubApplication {
        environment params.env
        file params.appArtifact
        cryptoKey params.cryptoKey
        autoDiscovery {
            clientId params.autoDiscClientId
            clientSecret params.autoDiscClientSecret
        }
        cloudHubAppPrefix 'tss'
        workerSpecs {
            muleVersion '4.4.0'
            workerType params.workerType
            workerCount params.workerCount.toInteger()
            awsRegion params.region
            objectStoreV2Enabled params.osv2Enabled.toBoolean()
        }
    }
}