import logging
import argparse
from threadpool import deploy_crawlers, str_to_bool

if __name__ == "__main__":
    
    logging.basicConfig(filename="logs/download.log", filemode="w", level=logging.DEBUG)
    parser = argparse.ArgumentParser("run main")

    parser.add_argument("-n", "--num_crawlers", type=int, default=1, help="Number of simultaneous crawlers to run")
    parser.add_argument("-w", "--all_wayback", type=str_to_bool, default=False, help="Whether to put all links through internet archive's wayback machine first, instead of using it as a fallback")
    
    args = parser.parse_args()
    deploy_crawlers(args)

