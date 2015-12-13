(ns flink-clj-example.WordCount
  (:import
    (org.apache.flink.api.common.functions FlatMapFunction)
    (org.apache.flink.api.java ExecutionEnvironment)
    (org.apache.flink.api.java.tuple Tuple2))
  (:require [clojure.string :as str])
  (:gen-class))

(def flink-env (ExecutionEnvironment/getExecutionEnvironment))

(def text (.fromElements flink-env (to-array ["please test me and me too"])))

(deftype tokenizer [] FlatMapFunction
  (flatMap [this value collector]
    (doseq [v (str/split value #"\s")]
      (.collect collector (Tuple2. v (int 1))))))

(def tokens (.returns (.flatMap text (tokenizer.)) "Tuple2<String,Integer>"))

(def counts (.sum (.groupBy tokens (int-array [0])) 1))

(defn -main []
  (.print counts)
  )

;; enable to execute within Intellij
;;(-main)