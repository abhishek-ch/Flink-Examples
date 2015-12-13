(defproject flink-clj-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/mjsax/flink-external/tree/master/flink-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.apache.flink/flink-clients "0.1.0-SNAPSHOT"]]
  :source-paths ["src/flink-clj-example/core"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :main flink-clj-example.WordCount)
