// This is a karma config file. For more details see
//   http://karma-runner.github.io/0.13/config/configuration-file.html
// we are also using it with karma-webpack
//   https://github.com/webpack/karma-webpack

var webpackConfig = require('../../../main/webapp/build/webpack.test.conf')
var configDev = require('../../../main/webapp/config/index.js')


const URL = process.env.URL.substring(7, process.env.URL.length-5);				// Extract the URL and remove http:// and :8081

console.log ("DATOS")
console.log (URL)


module.exports = function karmaConfig (config) {
	config.set({
		basePath: '',
		singleRun: true,
		failOnEmptyTestSuite: false,
		logLevel: 'debug',
		protocol: 'http',
		hostname: URL,
		listenAddress: URL,
		port: configDev.dev.port,
		browsers: ['PhantomJS'],									//browsers: ['PhantomJS', 'Chrome', 'Firefox'],

		frameworks: ['mocha', 'sinon-chai', 'phantomjs-shim'],
		reporters: ['spec', 'coverage'],
		files: ['./index.js'],
		transports: ['polling', 'websocket'],
    
	    preprocessors: {
	    	'./index.js': ['webpack', 'sourcemap']
	    },
	    webpack: webpackConfig,
	    webpackMiddleware: {
	    	noInfo: true
	    },
	    
	    //reporters: ['progress'],
	    reporters: ['junit', 'coverage', 'progress'],
	    junitReporter: {
	        outputDir: '',
	        outputFile: 'AuPair',
	        suite: '',
	        useBrowserName: false,
	        nameFormatter: undefined,
	        classNameFormatter: undefined,
	        properties: {}
	    },
	    coverageReporter: {
	    	dir: './coverage',
	    	reporters: [
	    		{ type: 'lcov', subdir: '.' },
	    		{ type: 'text-summary' }
	    	]
	    }
	})
}
