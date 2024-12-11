package com.objects;

import java.util.LinkedList;
import java.util.List;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;

public class Views {

    public static List<View1> runV1() {
        try {
            List<View1> res = new LinkedList<>();
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "SELECT * FROM `cs4400p4.business_supply.display_owner_view`"
                    ).setUseLegacySql(false)
                    .build();

            JobId jobId = JobId.newBuilder().setProject(Procedures.PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());
            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }

            TableResult result = queryJob.getQueryResults();

            for (FieldValueList row : result.iterateAll()) {
                // String type
                res.add(new View1(row.get("username").getStringValue(),
                row.get("first_name").getStringValue(), row.get("last_name").getStringValue(), 
                row.get("address").getStringValue(), row.get("num_businesses").getLongValue(), 
                row.get("num_places").getLongValue(), row.get("highs").getLongValue(), row.get("lows").getLongValue(),
                row.get("debt").getLongValue()));

            }
            return res;

        } catch (BigQueryException | InterruptedException e) {
            System.out.println("Simple App failed due to error: \n" + e.toString());
        }
        return null;
    }

    public static List<View2> runV2() {
        try {
            List<View2> res = new LinkedList<>();
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "SELECT * FROM `cs4400p4.business_supply.display_employee_view`"
                    ).setUseLegacySql(false)
                    .build();

            JobId jobId = JobId.newBuilder().setProject(Procedures.PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());
            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }

            TableResult result = queryJob.getQueryResults();

            for (FieldValueList row : result.iterateAll()) {
                // String type
                res.add(new View2(row.get("username").getStringValue(),
                row.get("taxID").getStringValue(), row.get("salary").getLongValue(),
                row.get("hired").getStringValue(), row.get("employee_experience").getLongValue(),
                row.get("licenseID").getStringValue(), row.get("driving_experience").getLongValue(),
                row.get("manager_status").getStringValue()));

            }
            return res;

        } catch (BigQueryException | InterruptedException e) {
            System.out.println("Simple App failed due to error: \n" + e.toString());
        }
        return null;
    }

    public static List<View3> runV3() {
        try {
            List<View3> res = new LinkedList<>();
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "SELECT * FROM `cs4400p4.business_supply.display_driver_view`"
                    ).setUseLegacySql(false)
                    .build();

            JobId jobId = JobId.newBuilder().setProject(Procedures.PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());
            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }

            TableResult result = queryJob.getQueryResults();

            for (FieldValueList row : result.iterateAll()) {
                // String type
                res.add(new View3(row.get("username").getStringValue(),
                row.get("licenseID").getStringValue(), row.get("driver_experience").getLongValue(),
                row.get("num_vans").getLongValue()));

            }
            return res;

        } catch (BigQueryException | InterruptedException e) {
            System.out.println("Simple App failed due to error: \n" + e.toString());
        }
        return null;
    }

    public static List<View4> runV4() {
        try {
            List<View4> res = new LinkedList<>();
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "SELECT * FROM `cs4400p4.business_supply.display_location_view`"
                    ).setUseLegacySql(false)
                    .build();

            JobId jobId = JobId.newBuilder().setProject(Procedures.PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());
            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }

            TableResult result = queryJob.getQueryResults();

            for (FieldValueList row : result.iterateAll()) {
                // String type
                res.add(new View4(row.get("label").getStringValue(),
                row.get("resolved_long_name").getStringValue(), row.get("x_coord").getLongValue(),
                row.get("y_coord").getLongValue(), row.get("space").getLongValue(), row.get("num_vans").getLongValue(),
                row.get("van_ids").getStringValue(), row.get("remaining_capacity").getLongValue()));

            }
            return res;

        } catch (BigQueryException | InterruptedException e) {
            System.out.println("Simple App failed due to error: \n" + e.toString());
        }
        return null;
    }

    public static List<View5> runV5() {
        try {
            List<View5> res = new LinkedList<>();
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "SELECT * FROM `cs4400p4.business_supply.display_product_view`"
                    ).setUseLegacySql(false)
                    .build();

            JobId jobId = JobId.newBuilder().setProject(Procedures.PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());
            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }

            TableResult result = queryJob.getQueryResults();

            for (FieldValueList row : result.iterateAll()) {
                // String type
                res.add(new View5(row.get("product_name").getStringValue(),
                row.get("location").getStringValue(), row.get("amount_available").getLongValue(),
                row.get("low_price").getLongValue(), row.get("high_price").getLongValue()));

            }
            return res;

        } catch (BigQueryException | InterruptedException e) {
            System.out.println("Simple App failed due to error: \n" + e.toString());
        }
        return null;
    }

    public static List<View6> runV6() {
        try {
            List<View6> res = new LinkedList<>();
            BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
            QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                    "SELECT * FROM `cs4400p4.business_supply.display_service_view`"
                    ).setUseLegacySql(false)
                    .build();

            JobId jobId = JobId.newBuilder().setProject(Procedures.PROJECTID).build();
            Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());
            queryJob = queryJob.waitFor();

            if (queryJob == null) {
                throw new RuntimeException("Job no longer exists");
            } else if (queryJob.getStatus().getError() != null) {
                throw new RuntimeException(queryJob.getStatus().getError().toString());
            }

            TableResult result = queryJob.getQueryResults();

            for (FieldValueList row : result.iterateAll()) {
                // String type
                res.add(new View6(row.get("id").getStringValue(),
                row.get("long_name").getStringValue(), row.get("home_base").getStringValue(),
                row.get("manager").getStringValue(), row.get("revenue").getLongValue(),
                row.get("products_carried").getLongValue(), row.get("cost_carried").getLongValue(),
                row.get("weight_carried").getLongValue()));

            }
            return res;

        } catch (BigQueryException | InterruptedException e) {
            System.out.println("Simple App failed due to error: \n" + e.toString());
        }
        return null;
    }
}

